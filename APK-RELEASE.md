# APK Release Build Guide

## 🚀 Generare APK Release Firmato

### Metodo 1: Script Automatico (Consigliato)

#### Su Linux/Mac:
```bash
chmod +x build-release-full.sh
./build-release-full.sh
```

#### Su Windows:
```cmd
build-release.bat
```

### Metodo 2: Manuale via Android Studio

1. **Build → Generate Signed Bundle / APK**
2. **Seleziona APK**
3. **Next → Create new** (se non hai keystore)
4. Compila i campi:
   - **Key store path**: `app/stazione-posta-release.keystore`
   - **Password**: `stazione2026`
   - **Key alias**: `stazione_posta_key`
   - **Key password**: `stazione2026`
5. **Next → Release → Finish**

### Metodo 3: Manuale via Gradle

```bash
# Linux/Mac
./gradlew clean assembleRelease

# Windows
gradlew.bat clean assembleRelease
```

---

## 📱 Installare l'APK

### Via ADB (Consigliato)

```bash
# Connetti il dispositivo via USB
adb devices

# Installa l'APK
adb install app/build/outputs/apk/release/app-release.apk
```

### Via File Transfer

1. Copia `app/build/outputs/apk/release/app-release.apk` sul dispositivo
2. Apri il file manager
3. Tocca il file `.apk`
4. Clicca "Installa"

---

## 🔐 Credenziali di Accesso

| Operatore | PIN  |
|-----------|------|
| Mario     | 1111 |
| Vio       | 2222 |
| Nicola    | 3333 |
| Claudio   | 4444 |

---

## 📊 Dettagli del Build

### Keystore Predefinito
- **File**: `app/stazione-posta-release.keystore`
- **Password**: `stazione2026`
- **Alias**: `stazione_posta_key`
- **Validità**: 10000 giorni (~27 anni)

### Optimizzazioni Release
- ✅ Codice minificato (ProGuard)
- ✅ Librerie non utilizzate rimosse
- ✅ Debug info rimosso
- ✅ Firma digitale applicata
- ✅ Riduzione dimensioni file

---

## 🔍 Verificare la Firma

```bash
# Vedere i dettagli del certificato
keytool -printcert -jarfile app/build/outputs/apk/release/app-release.apk

# Verificare l'integrità dell'APK
jarsigner -verify -verbose app/build/outputs/apk/release/app-release.apk
```

---

## 📈 Dimensioni Tipiche

- **Debug APK**: ~50-80 MB
- **Release APK**: ~20-30 MB (ottimizzato)

---

## ⚠️ Importante

- **NON fare commit** del keystore su GitHub (già in `.gitignore`)
- **Backup il keystore** in un luogo sicuro
- **Memorizza la password** in un gestore di password
- Se perdi il keystore, **non puoi aggiornare l'app** sullo Store

---

## 🐛 Troubleshooting

### Errore: "Keystore file not found"
```bash
# Assicurati di essere nella directory del progetto
cd /path/to/stazione-di-posta-reset1
```

### Errore: "keytool not found"
```bash
# Su Windows, aggiungi Java/bin al PATH
# Su Linux/Mac, installa OpenJDK
sudo apt-get install openjdk-11-jdk-headless
```

### Errore: "gradle: command not found"
```bash
# Usa il wrapper
./gradlew clean assembleRelease  # Linux/Mac
gradlew.bat clean assembleRelease  # Windows
```

---

## 📲 Pronto per il Deploy!

Una volta generato l'APK, puoi:
- ✅ Distribuire ai tuoi operatori
- ✅ Caricare su Play Store (futuro)
- ✅ Condividere via email/cloud
- ✅ Installare su più dispositivi

**Versione**: 1.0.0  
**Data Build**: 2026-06-27
