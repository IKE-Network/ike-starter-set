# Tutorial: Adding a New Chapter to `ike-guide`

With the **Decentralized Hierarchy Plugin**, adding a new chapter requires **zero edits to `ike-guide.adoc`**. You simply create your chapter file and register it using the plugin (or write the 4 header lines manually).

---

### How It Works in 30 Seconds

```text
1. Write Draft (.adoc)  ──>  2. Run 'add-chapter' Goal  ──>  3. Build Docs
(Anywhere in project)        (Adds :chapter-parent: ike-guide) (Auto-discovered & Rendered)
```

---

### Step-by-Step Checklist

#### Phase 1: Write Your Chapter Draft

- [ ] **Step 1.1: Create Your AsciiDoc File**
  - Create a new `.adoc` file anywhere in your project (for example, in `ike-doc/src/docs/asciidoc/chapters/my-new-chapter.adoc` or in your domain submodule).

- [ ] **Step 1.2: Write Your Content Starting with a Level 1 Heading (`=`)**
  - Write standard AsciiDoc starting with `= Chapter Title`:
    ```asciidoc
    = My New Feature Guide

    == Overview
    This is an overview of the new feature.

    == Getting Started
    Follow these steps to configure and use the feature.
    ```
  > Note: Always start your chapter title with a single equal sign (`= Title`). The hierarchy plugin automatically calculates and shifts headings (`leveloffset=+1`) when assembling the book.

---

#### Phase 2: Register the Chapter with the Plugin

You can register your chapter automatically with one command or manually:

- [ ] **Step 2.1: Run the `add-chapter` Command (Recommended)**
  - Run this command from your project root (replacing the filename and desired order position):
    ```bash
    mvn ike-hierarchy:add-chapter \
      -Dfile=ike-doc/src/docs/asciidoc/chapters/my-new-chapter.adoc \
      -Dparent=ike-guide \
      -Dorder=250
    ```

- [ ] **Step 2.2: Verify the Generated Header**
  - Open your file; the plugin will have prepended these 4 lines at the top:
    ```asciidoc
    :chapter-id: my-new-chapter
    :chapter-parent: ike-guide
    :chapter-order: 250
    :chapter-status: published

    = My New Feature Guide
    ...
    ```

#### Understanding Chapter Ordering (`-Dorder`):
- Chapters are sorted numerically by `:chapter-order:`.
- Core chapters are numbered in increments of 100 (e.g., `100` = How to Read, `200` = What This Set Provides, `300` = Language Concepts).
- Setting `-Dorder=250` automatically places your chapter **between Chapter 2 and Chapter 3**.

---

#### Phase 3: Validate and Index the Hierarchy

- [ ] **Step 3.1: Validate Hierarchy Integrity**
  - Run the `validate` or `index` goal to confirm that parent pointers, ordering, and depth rules are valid:
    ```bash
    mvn ike-hierarchy:index -Denforcer.skip=true
    ```
  - **Output:**  
    `Examined 36 AsciiDoc files... Placed 25 entries under 1 assembly root(s): [ike-guide]`

---

#### Phase 4: Build and View Your Live Chapter

- [ ] **Step 4.1: Compile Documentation**
  - Re-render the HTML documentation:
    ```bash
    mvn generate-resources -pl ike-doc -Denforcer.skip=true
    ```

- [ ] **Step 4.2: Open and Verify in Your Browser**
  - Launch the compiled guide:
    ```bash
    open ike-doc/target/generated-docs/ike-guide.html
    ```
  - Result: Your chapter appears automatically in the sidebar Table of Contents and in the body text at the exact position specified by `:chapter-order:`.

---

### Common Operations & Tips

| Action | Command / Attribute |
| :--- | :--- |
| **Move a Chapter** | Change `:chapter-order: 550` or re-run `mvn ike-hierarchy:add-chapter -Dfile=... -Dorder=550` |
| **Nest Under Another Chapter** | Set `:chapter-parent: <parent-chapter-id>` (subsections nest automatically) |
| **Hide a Draft Chapter** | Set `:chapter-status: draft` (won't render until changed to `published`) |
| **Check for Broken References** | Run `mvn ike-hierarchy:validate` in CI to catch missing parents or duplicate IDs |
