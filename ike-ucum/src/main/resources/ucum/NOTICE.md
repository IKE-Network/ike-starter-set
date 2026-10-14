# The Unified Code for Units of Measure, the source of the unit family

`ucum-essence.xml` in this directory is the Unified Code for Units of Measure (UCUM), version
2.2, revision date 2024-06-17, taken unchanged from
https://github.com/ucum-org/ucum at tag v2.2. It is reproduced here with the notices its
license requires:

- **Copyright notice.** The Unified Code for Units of Measure (UCUM), also known as the UCUM
  Specification, is copyright © 1999-2024, Regenstrief Institute, Inc. All rights reserved.
- **License.** It is licensed under the UCUM Copyright Notice and License, version 1.1, June
  2024, whose full text is in `LICENSE.md` beside it and at https://ucum.org/license.
- **Disclaimer of warranties.** The Work is provided on an "as is" basis, without warranties
  or conditions of any kind, as Section 7 of that license states.
- **Where the license is.** `LICENSE.md` in this directory; https://ucum.org/license.

The file is never modified. The IKE knowledge base reads it, unmodified, when a knowledge base
is assembled, and represents each prefix, base unit, and unit as a concept whose code, name,
print symbol, property, class, and definition are UCUM's own words, verbatim. Everything IKE
adds, identity, the patterns, and the dimensions and magnitudes it computes from UCUM's
definitions, is IKE's and is marked so. The license names software that interoperates with an
unmodified instance of the Work as not a derivative work, and that is what this is
(IKE-Network/ike-issues#1114).
