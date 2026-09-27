# IntelliJ IDEA: Useful macOS Shortcuts

Assumes IntelliJ IDEA's default **macOS** keymap. Function keys (`F6`, `F7`, etc.) below assume macOS is configured to use the top row as standard function keys.

## Configure function keys

To use `F1`, `F2`, and so on without holding `fn`:

1. Open **Apple menu → System Settings → Keyboard**.
2. Select **Keyboard Shortcuts… → Function Keys**.
3. Enable **Use F1, F2, etc. keys as standard function keys**.

Hold `fn` (or Globe) when you want the normal macOS media and brightness controls instead.

## Everyday essentials

| Action | Shortcut |
| --- | --- |
| Search everywhere | `Shift` twice |
| Find an action or setting | `Cmd Shift A` |
| Open recent files | `Cmd E` |
| Open file by name | `Cmd Shift O` |
| Search for a class, method, or symbol | `Cmd Option O` |
| Project tool window | `Cmd 1` |
| Terminal | `Option F12` |
| Switch open files/tool windows | `Control Tab` |
| Back / forward through navigation | `Cmd [` / `Cmd ]` |
| Last edit location | `Cmd Shift Delete` |
| File structure popup | `Cmd F12` |
| Next / previous method | `Control Shift Down` / `Control Shift Up` |

## Code navigation and object relationships

Place the caret on a class, interface, method, or variable first.

| Action | Shortcut |
| --- | --- |
| Go to declaration or usage | `Cmd B` |
| Go to type declaration | `Cmd Shift B` |
| Go to super method / overridden interface method | `Cmd U` |
| Go to implementation(s) | `Cmd Option B` |
| Type hierarchy: parent classes, child classes, implementors | `Control H` |
| Method hierarchy: inherited and overridden methods | `Control Shift H` |
| Call hierarchy: callers and callees | `Control Option H` |
| Find all usages | `Option F7` |
| Show usages popup | `Cmd Option F7` |
| Highlight usages in current file | `Cmd Shift F7` |
| Go to test / create test | `Cmd Shift T` |

### A useful exploration flow

1. `Cmd Option B` — see concrete implementations of an interface or abstract method.
2. `Control H` — understand the type hierarchy.
3. `Control Option H` — trace who calls a method or what it calls.
4. `Cmd [` — return to where you started.

## Editing and generation

| Action | Shortcut |
| --- | --- |
| Quick fix / intention actions | `Option Enter` |
| Basic completion | `Control Space` |
| Type-matching completion | `Control Shift Space` |
| Generate constructor, getters, overrides, etc. | `Cmd N` |
| Duplicate line or selection | `Cmd D` |
| Delete line | `Cmd Delete` |
| Move line/statement up or down | `Option Shift Up` / `Option Shift Down` |
| Expand / shrink selection by syntax | `Cmd Option Up` / `Cmd Option Down` |
| Toggle line comment | `Cmd /` |
| Toggle block comment | `Cmd Option /` |
| Surround selection (`if`, `try/catch`, etc.) | `Cmd Option T` |
| Reformat code | `Cmd Option L` |
| Optimize imports | `Control Option O` |
| Rename safely | `Shift F6` |
| Refactoring menu | `Control T` |
| Extract method | `Cmd Option M` |

## Debugging

| Action | Shortcut |
| --- | --- |
| Run current configuration | `Control R` |
| Debug current configuration | `Control Option D` |
| Open Debug tool window | `Cmd 5` |
| Toggle breakpoint | `Cmd F8` |
| Manage breakpoints | `Cmd Shift F8` |
| Step over | `F8` |
| Step into | `F7` |
| Step out | `Shift F8` |
| Run to cursor | `Option F9` |

When paused, select a frame in the Debug tool window's call stack to jump directly to its source.

## Version control and focus

| Action | Shortcut |
| --- | --- |
| Commit | `Cmd K` |
| Push | `Cmd Shift K` |
| Update project / pull | `Cmd T` |
| Hide active tool window | `Shift Escape` |
| Hide all tool windows / focus editor | `Cmd Shift F12` |

## Notes

- `Control Space` may conflict with macOS input-source switching. Reassign that macOS shortcut or change IntelliJ's completion binding if needed.
- All bindings are configurable in **IntelliJ IDEA → Settings → Keymap**.
- Use **Help → Keyboard Shortcuts PDF** in IntelliJ for JetBrains' complete printable reference.
