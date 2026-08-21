## Prerequisites

- Android Studio (Ladybug or newer recommended)
- JDK 17+
- Android SDK with compileSdk 37

## Setup

> **Note:** The signing block in `app/build.gradle.kts` reads `STORE_PASSWORD` and `KEY_PASSWORD` from environment variables (or `local.properties`) — never commit those values.

## Build

```bash
./gradlew assembleDebug   # debug APK
./gradlew assembleRelease # release APK (requires signing config)
```

## Project

- **Language:** Kotlin + Jetpack Compose
- **Min SDK:** 31 (Android 12)
- **Target SDK:** 36
- **Camera:** CameraX (Camera2 core)
- **Image loading:** Coil

## Screenshots

_(Coming soon)_

## License

See [LICENSE](LICENSE).
