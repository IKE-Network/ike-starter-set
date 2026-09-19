#!/usr/bin/env python3
"""Writes one CQL library per file of the CQL test suite: each valid test becomes two
definitions, its expression and its expected result, and a manifest records every test,
the invalid ones included, so that the gate can count what passed, what was refused, what
was recorded, and what the suite itself marks invalid."""
import json, pathlib, re, sys, xml.etree.ElementTree as ET
NS = '{http://hl7.org/fhirpath/tests}'
source, target = pathlib.Path(sys.argv[1]), pathlib.Path(sys.argv[2])
target.mkdir(parents=True, exist_ok=True)
# Tests the pinned translator (cql-to-elm 3.29.0) cannot translate, kept in the manifest as
# untranslated with the translator's own words, and left out of the libraries.
UNTRANSLATED = {
    'DateTimeComponentFromTimezoneOffset': 'Timezone keyword is only valid in 1.3 or lower',
}
UNTRANSLATED_PREFIX = {'Slice': 'Could not resolve call to operator Slice'}
manifest = []
for xml in sorted(source.glob('*.xml')):
    root = ET.parse(xml).getroot()
    library = xml.stem
    lines = [f"library {library} version '1.0'", '']
    for group in root.iter(NS + 'group'):
        for test in group.findall(NS + 'test'):
            name = test.get('name')
            expression = test.find(NS + 'expression')
            output = test.find(NS + 'output')
            invalid = expression.get('invalid') or (None if output is not None else 'true')
            untranslated = UNTRANSLATED.get(name)
            for prefix, reason in UNTRANSLATED_PREFIX.items():
                if name.startswith(prefix):
                    untranslated = reason
            entry = {'file': library, 'group': group.get('name'), 'name': name,
                     'expression': (expression.text or '').strip(),
                     'expected': (output.text or '').strip() if output is not None else None,
                     'invalid': invalid, 'untranslated': untranslated}
            manifest.append(entry)
            if invalid or untranslated:
                continue
            lines.append(f'define "{name}": {entry["expression"]}')
            lines.append(f'define "{name}_expected": {entry["expected"]}')
    (target / f'{library}.cql').write_text('\n'.join(lines) + '\n', encoding='utf-8')
(target / 'manifest.json').write_text(json.dumps(manifest, indent=1), encoding='utf-8')
valid = sum(1 for e in manifest if not e['invalid'] and not e['untranslated'])
untranslated = sum(1 for e in manifest if e['untranslated'])
print(f'{len(manifest)} tests, {valid} translated, {sum(1 for e in manifest if e["invalid"])} invalid, {untranslated} untranslated, {len(set(e["file"] for e in manifest))} libraries')
