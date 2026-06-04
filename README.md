## Prerequisites

- Android Studio (Ladybug or newer recommended)
- JDK 17+
- Android SDK with compileSdk 37

## Setup

```bash
# Copy the example env file and fill in your values
cp .env.example .env
```

Add your `GEMINI_API_KEY` to `.env` (loaded by the Secrets Gradle Plugin).

> **Note:** The signing block in `app/build.gradle.kts` reads `STORE_PASSWORD` and `KEY_PASSWORD` from environment variables (set in `.env` or your shell) — never commit those values.

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
- **Networking:** Retrofit + Moshi
- **Local storage:** Room
- **Image loading:** Coil

## Screenshots

_(Coming soon)_

## License

See [LICENSE](LICENSE).
