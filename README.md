# Stazione di Posta Reset1 - Gestionale Servizi

Applicazione Android completa per la gestione dei servizi di una stazione di posta mobile.

## 🎯 Funzionalità Principali

- ✅ **Conteggio ingressi** automatico per 5 servizi
- ✅ **Autenticazione con PIN** per 4 operatori (Mario, Vio, Nicola, Claudio)
- ✅ **Schede utenti** con storico completo degli ingressi
- ✅ **Report dinamici** in PDF ed Excel
- ✅ **Report giornalieri, settimanali, mensili** con statistiche
- ✅ **Database locale SQLite** - nessuna connessione internet necessaria
- ✅ **Interfaccia intuitiva** con Material Design
- ✅ **Ricerca utenti** in tempo reale

## 📱 Servizi Tracciati

1. **Docce**
2. **Lavatrici**
3. **Segretariato Sociale**
4. **Merende**
5. **Vestiario**

## 👥 Operatori

L'app supporta 4 operatori con accesso tramite PIN:

| Nome | PIN |
|------|-----|
| Mario | 1111 |
| Vio | 2222 |
| Nicola | 3333 |
| Claudio | 4444 |

## 🛠️ Stack Tecnologico

- **Linguaggio**: Kotlin/Java
- **Framework**: Android SDK
- **Database**: SQLite con Room ORM
- **Report**: Apache POI (Excel) + iText (PDF)
- **UI**: Material Design
- **Min API**: 26 (Android 8.0+)
- **Target API**: 34 (Android 14)

## 📦 Dipendenze Principali

```gradle
- androidx.appcompat:appcompat:1.6.1
- androidx.room:room-runtime:2.5.2
- com.google.android.material:material:1.9.0
- org.apache.poi:poi:5.2.3
- com.itextpdf:itextpdf:5.5.13.3
- com.github.PhilJay:MPAndroidChart:v3.1.0
```

## 🚀 Avvio Rapido

### Requisiti
- Android Studio 2022.1+
- JDK 11+
- Android SDK 26+

### Installazione

1. Clone il repository
```bash
git clone https://github.com/pallantemario0-sudo/stazione-di-posta-reset1.git
```

2. Apri in Android Studio
3. Sincronizza Gradle
4. Esegui su dispositivo/emulatore

Vedi [INSTALL.md](INSTALL.md) per una guida dettagliata.

## 💾 Database

Tutti i dati vengono salvati localmente nel dispositivo Android:
- Operatori e credenziali
- Utenti registrati
- Storico ingressi per ogni servizio
- Report generati

## 📊 Report

L'app consente di generare report in due formati:

### PDF
- Report formattato e pronto per la stampa
- Incluso timestamp e riepilogo statistiche

### Excel
- Dati in formato tabellare
- Facile integrazione con altri tool
- Possibilità di creare grafici aggiuntivi

Report salvati in: `/Documents/StazioneReset1/`

## 🔒 Permessi Richiesti

- `INTERNET` - Per future sincronizzazioni (opzionale)
- `READ_EXTERNAL_STORAGE` - Per leggere file
- `WRITE_EXTERNAL_STORAGE` - Per salvare report
- `MANAGE_EXTERNAL_STORAGE` - Per accesso completo storage

## 📝 Utilizzo

### Accesso
1. Avvia l'app
2. Inserisci il PIN operatore
3. Accedi al dashboard

### Registrare un Ingresso
1. Clicca "Conteggio Servizi"
2. Seleziona il servizio
3. Seleziona o crea l'utente
4. L'ingresso viene registrato automaticamente

### Visualizzare Utenti
1. Clicca "Gestione Utenti"
2. Ricerca per nome
3. Clicca "Visualizza Dettagli" per storico completo

### Generare Report
1. Clicca "Genera Report"
2. Seleziona tipo (Giornaliero/Settimanale/Mensile)
3. Seleziona formato (PDF/Excel)
4. Clicca "Genera"

## 🐛 Segnalazione Bug

Per segnalare bug o richiedere features:
1. Apri un [issue](https://github.com/pallantemario0-sudo/stazione-di-posta-reset1/issues)
2. Descrivi il problema in dettaglio
3. Includi screenshot se possibile

## 📄 Licenza

Questo progetto è licensato sotto [MIT License](LICENSE).

## 👨‍💼 Autore

**Stazione di Posta Reset1**

Creato per gestire i servizi di una stazione di posta mobile con focus su semplicità d'uso e tracciamento dati offline.

## 🎓 Guida per Sviluppatori

### Struttura Progetto
```
app/src/main/
├── java/com/stazioneposta/reset1/
│   ├── data/
│   │   ├── AppDatabase.kt
│   │   ├── Operator.kt
│   │   ├── User.kt
│   │   ├── Service.kt
│   │   ├── Entry.kt
│   │   └── dao/
│   ├── ui/
│   │   ├── MainActivity.kt
│   │   ├── LoginActivity.kt
│   │   ├── DashboardActivity.kt
│   │   ├── CounterActivity.kt
│   │   ├── UsersActivity.kt
│   │   ├── ReportsActivity.kt
│   │   └── adapter/
│   └── utils/
│       └── ReportGenerator.kt
└── res/
    ├── layout/
    └── values/
```

### Aggiungere un Nuovo Servizio

1. Modifica `ServiceType.kt`
2. Aggiungi il servizio a `services` in `CounterActivity`
3. Esegui rebuild

### Personalizzare i PIN

Modifica `LoginActivity.kt`:
```kotlin
private val defaultOperators = listOf(
    Operator(name = "Nome", pin = "1234"),
    // ...
)
```

## 📞 Contatti

Per domande o supporto, contatta lo sviluppatore del progetto.

---

**Versione**: 1.0.0  
**Ultimo Aggiornamento**: 27 Giugno 2026
