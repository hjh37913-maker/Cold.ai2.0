# Architecture

## Module strategy

This project uses a single Android app foundation with clearly separated packages that emulate a modular architecture. The idea is to scale from a single app into dedicated Gradle modules without changing the core design.

## Core packages

- `com.coldai.app` — application entry points and composition root.
- `com.coldai.core.ai` — provider abstraction and orchestration.
- `com.coldai.core.task` — task planning and execution state model.
- `com.coldai.core.memory` — local memory and routines.
- `com.coldai.core.automation` — triggers and rules.
- `com.coldai.core.permissions` — permission gating.
- `com.coldai.core.security` — confirmation and sensitive action checks.
- `com.coldai.core.voice` — voice interaction abstraction.
- `com.coldai.core.system` — diagnostics and health reporting.

## Design principles

- local-first memory;
- explicit permission flow;
- modular interfaces rather than monolithic logic;
- gracefully degrade in offline mode;
- deterministic validation for safety-critical actions.

## Future scaling

This foundation is structured to evolve into separate modules such as:

- `:feature:home`
- `:feature:voice`
- `:feature:automation`
- `:feature:memory`
- `:feature:settings`
- `:core:ai`
- `:core:task`

## UI architecture

The UI is composed using Jetpack Compose with a basic navigation graph. The home screen is designed for a professional personal assistant dashboard. The command center exposes the major feature domains without fake decorative elements.
