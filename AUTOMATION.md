# Security

## Safety principles

- local-first design with explicit user consent;
- confirmation required for sensitive operations;
- runtime permissions only when needed;
- no API keys in source code;
- no silent data collection.

## Sensitive actions

Examples of actions that should require explicit confirmation:

- calls;
- SMS sends;
- deletions;
- external message actions;
- destructive file operations;
- unexpected automation triggers.

## Permission management

Permissions are requested only when relevant to the user intent. This prevents unnecessary access and preserves user trust.
