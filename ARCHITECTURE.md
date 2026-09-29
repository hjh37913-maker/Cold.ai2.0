# COLD AI

COLD AI is a professional Android personal AI assistant foundation designed for local-first orchestration, task execution, automation, memory, and app/system integration.

## Overview

This repository contains a production-oriented Android foundation for a personal AI assistant that can:

- understand voice requests;
- route intent to the right action path;
- execute multi-step tasks;
- manage memory and routines;
- enforce permission checks and security confirmations;
- support offline-safe behavior;
- provide a professional, polished UI.

## Architecture

The application is organized into clear layers:

- UI layer: Compose screens and navigation.
- Core layer: AI, task planning, memory, automation, permissions, security, voice, diagnostics.
- Platform layer: Android APIs, manifest, system integrations, settings, offline capabilities.

## Getting started

1. Install Android Studio Ladybug or newer.
2. Open the repository in Android Studio.
3. Ensure Android SDK 34 is installed.
4. Sync Gradle.
5. Run the `:app` configuration on a connected device or emulator.

## Build

```bash
./gradlew assembleDebug
```

## Permissions

The app requests runtime permissions on demand rather than at install time. Relevant permissions include:

- RECORD_AUDIO
- POST_NOTIFICATIONS
- READ_CONTACTS
- READ_CALENDAR
- CALL_PHONE

## AI configuration

This project uses a provider abstraction for future compatibility with:

- Gemini
- OpenAI-compatible APIs
- local model adapters

No API keys are hardcoded. Use environment variables or secure local configuration.

## Testing

Run:

```bash
./gradlew test
./gradlew connectedDebugAndroidTest
```

## Release

Before publishing:

- replace debug signing config with real release signing credentials;
- review permissions and privacy posture;
- validate all critical actions require confirmation where appropriate;
- test offline and permission-denied flows.

## Security notes

- Never hardcode secret keys.
- Never record user audio without clear consent.
- Never perform sensitive actions without confirmation.
- Favor local-first memory and local execution where possible.
