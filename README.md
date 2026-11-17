# Lavanderiamerge

Esercizio di gruppo (4 persone) per fare pratica con **branch, commit, Pull Request e conflitti di merge**.

Il progetto è una piccola lavanderia scritta in Java: i clienti portano dei capi, la lavanderia crea un ordine,
li lava con il programma giusto e avvisa il cliente quando l'ordine è pronto.
Ognuno di noi aggiunge un **design pattern** lavorando sul proprio branch.

## Squadra

| Persona | Nome | Branch | Pattern | Cosa aggiunge |
|---|---|---|---|---|
| 1 | Laura Casota | `feature/singleton` | Singleton | `Lavanderia`: un'unica istanza che crea e conserva gli ordini |
| 2 | Marco Manto | `feature/factory` | Factory | `CapoFactory`: crea camicie, jeans, cappotti e piumoni |
| 3 | Antonio Scognamiglio | `feature/strategy` | Strategy | `StrategiaLavaggio`: lavaggio standard, delicato, a secco, igienizzante |
| 4 | Mariano Potena | `feature/observer` | Observer | Notifiche SMS ed email quando cambia lo stato di un ordine |

## Struttura di partenza (branch `main`)

```
src/it/lavanderia/
  Main.java              punto di avvio: ognuno ci aggiunge la chiamata alla sua demo
  model/
    Capo.java            un capo da lavare (nome + prezzo base)
    Ordine.java          un ordine: cliente, capi, stato, totale
    StatoOrdine.java     RICEVUTO, IN_LAVAGGIO, PRONTO, RITIRATO
```

## Come avviarlo

- **Eclipse / IntelliJ / VS Code**: aprire il progetto (la cartella dei sorgenti è `src`) ed eseguire `it.lavanderia.Main`.
- **Terminale (PowerShell)**, dalla cartella della repo:

  ```powershell
  javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
  java -cp out it.lavanderia.Main
  ```

## Regole del gioco

1. Su `main` non si committa direttamente: si lavora solo sul proprio branch `feature/...`.
2. Commit piccoli e con messaggi chiari (es. `Aggiunge la classe CapoFactory`).
3. Ognuno modifica solo i file indicati nella sua guida.
4. Le Pull Request si uniscono in quest'ordine: **Singleton → Factory → Strategy → Observer**.
5. Quando GitHub segnala un conflitto, lo si risolve in locale sul proprio branch, poi si fa il merge della PR.
