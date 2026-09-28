---
name: dsa-review-problem
description: "Create a dated Java reimplementation for a DSA practice problem and maintain practice/INDEX.md. Use when revisiting an existing problem."
---

# DSA Review Problem

Create a new dated review implementation for one existing practice problem. This skill is deliberately tool- and agent-agnostic: it describes file outcomes and checks, not editor, shell, or platform commands.

## Inputs

Obtain or infer the problem name, topic, and canonical package directory. Practice problems use the structure `topic/exercise-name`, for example `hash/validanagram`. Preserve the repository's existing language, package, and naming conventions.

Do not treat `workspace` (or another generic scratch package) as a canonical problem directory. If an older implementation exists only there, leave it intact and create the review in the appropriate topic/exercise package.

## Workflow

1. Locate the canonical problem directory under `practice/src/main/java/<base-package>/<topic>/<exercise-name>/`. Infer the topic from the exercise when it is clear, using existing topic directories and their naming conventions. Do not create a second directory for a problem that is already present under a different spelling. A generic `workspace` package is an exception: it is not a problem directory and must not be used for a review.
2. Determine the review date in the repository user's local date and name the new file `ReviewYYYY_MM_DD.java`. If that exact filename already exists, do not overwrite it: ask whether to amend it or use a new, explicitly selected date.
3. Add the file in the canonical topic/exercise package. Match the package declaration used by neighboring Java files. Create a public class with the matching `ReviewYYYY_MM_DD` name and a short comment identifying the problem and review date. Leave the implementation ready for the learner to write; do not copy an older solution unless the user asks for a reference implementation.
4. Update `practice/INDEX.md` rather than creating per-problem Markdown files. Find the existing row for the same problem and append the review marker `YYYY-MM` (or the repository's established equivalent) to its **Implementations** field, then update **Last reviewed** to `YYYY-MM`. Preserve all other metadata and table formatting. If a legacy original remains in a generic scratch package, retain its link and link the new review in its canonical topic/exercise package.
5. If the problem has no index row, add one in the relevant topic section using only known metadata. Link its problem name directly to the package directory or the original Java solution, consistently with the existing index. Mark source metadata as unknown rather than guessing.

## Guardrails

- Keep original solutions and earlier review files intact.
- Do not rename, move, or delete problem folders as part of a review.
- Do not add site-specific labels such as “LeetCode” unless the problem's existing metadata identifies that source.
- Do not update the review queue unless the user asks, or the index already has an explicit rule that a completed review is removed or checked off.

## Verify

Before finishing, check that the Java filename and public class name agree, the package declaration matches the `topic/exercise-name` directory convention, the new review is not in a generic scratch package, and the index has exactly one corresponding updated or added row. Run the repository's focused Java build or formatter if it is available and does not require unrelated setup.

## Portable installation

The skill contains only `SKILL.md`; copy this directory into the skill-discovery location used by another agent (for example Claude Code, OpenCode, or Codex). The instructions rely only on the repository layout above and require no agent-specific commands or integrations.
