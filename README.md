# REFACTOR CHALLENGE

## Refactoring
"Refactoring" significa migliorare la struttura interna del codice di un programma esistente, preservandone il _comportamento_ esterno.

Con il termine "refactoring" si intendono pertanto  tutte quelle tecniche che hanno come obiettivo il miglioramento del design del codice esistente. Queste tecniche si applicano in passi che devono essere **piccoli abbastanza** per mantenere il _comportamento_ del codice che si sta modificando: "too small to be worth doing". 

La ristrutturazione del codice esistente in piccoli passi **riduce il rischio** d'introdurre errori e quindi di rompere il sistema. Per basi di codice di grandi dimensioni, procedere gradualmente permette di eseguire refactoring che possono durare per un lungo periodo di tempo.

Alcune delle tecniche che rispondo alla descrizione sono ad esempio l'estrazione di un metodo, eseguire un inline di una variabile, l'introduzione di un paramento in un metodo privato, etc.

"Refactoring" quindi **non** significa:
- riscrivere il codice
- risolvere bug
- migliorare parti osservabili del codice, come ad esempio le interfacce verso l'esterno

Fare "refactoring" senza _rete di protezione_ è decisamente rischioso: test unitari e di accettazione automatizzati sono indispensabili per procedere.

Alcuni benefici per i quali si fa "refactoring" sono:
- diminuire la lunghezza di metodi e classi
- rimuovere duplicazioni
- aumentare la coesione, diminuire l'accoppiamento
- ridurre la complessità ciclomatica (numero di cammini linearmente indipendenti)
- aumentare la leggibilità del codice
- favorire l'identificazione di metodi, oggetti, moduli riutilizzabili
- riconoscere problemi noti e applicare soluzioni note (design pattern)
- accrescere la manutenibilità del codice

## Code smells
Il termine "smell" è stato introdotto da Kent Beck. Gli "smell" non sono bug: un codice _che puzza_ è un codice che può comunque lavorare correttamente. Gli "smell" sono punti deboli nel codice che potrebbero portare a bug in futuro e che _gridano refactoring_ :-)

I "code smell" sono tantissimi: almeno un centinaio e si dividino sostanzialmente in due tipi:
- quelli **dentro** le classi
- quelli **tra** le classi 

Qualche esempio di "smell" **dentro** le classi:
- **Primitive Obsession**: usando troppi tipi primitivi si rischia di nascondere l'intento del codice. Estrarre classi, sostituire i primitivi con degli oggetti sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.
- **Duplicated Code**: la duplicazione si può presentare in diverse forme. Ci possono essere linee di codice simili oppure classi con nomi che si assomigliano che esprimo lo stesso intento. L'estrazione di un metodo o di una classe oppure spostare un metodo in un super classe sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.
- **Comments**: i commenti posso spiegare l'intento di un pezzo di codice ma sono in realtà il segno di nomi poco parlanti, metodi troppo lunghi, codice poco leggibile. L'estrazione di un metodo oppure l'utilizzo di nomi appropriati sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.
- **Long Method**: un metodo troppo lungo è difficile da leggere e da comprendere perché ricco di dettagli. Metodi troppo lunghi tendono a nascondere la duplicazione e a essere pieni di **Primitive Obsession**. Meglio optare per metodi brevi, con nomi espressivi che aiutino a comprendere velocemente ciò che il metodo fa. La sostituzione di un metodo con un oggetto, la decomposizione delle condizioni o l'estrazione di un metodo sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.
- **Switch Statements**: lo switch può essere un costrutto ottimo col paradigma procedurale ma non lo è in alcun modo col paradigma ad oggetti. La sostituzione delle condizioni col polimorfismo, l'introduzione di _Null Object_, la sostituzione con sotto classi o stati o strategie sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.

Qualche esempio di "smell" **tra** le classi:
- **Data Clumps**: liste di campi o parametri o entrambi, ripetute. Questo "smell" non è sempre di facile individuazione poiché i nomi dei campi e dei parametri posso essere diversi anche quando il loro scopo é lo stesso. Prima di procedere alle mosse di refactoring per elimanare questo smell potrebbe essere necessario rinominare campi e parametri.
- **Feature Envy**: un comportamento che sembra più interessato ai dati di un'altra classe che alla classe che lo contiene. L'estrazione o lo spostamento di un metodo ono alcune delle mosse di refactoring utilizzate per eliminare questo smell.
- **Message Chains/Train Wrecks**: `obcject.getThis().getThat().getSuch().doSth()` è un esempio di questo "smell" che rende un oggetto dipendente da tutti gli oggetti presenti nella catena di invocazione dei metodi. L'estrazione di o il rinominare un metodo sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.
- **Shotgun Surgery/Solution Sprawl**: il codice soffre di questo smell quando un cambiamento ad esso implica un cambiamento in molte altre classi. L'estrazione di un metodo, lo spostamento di un campo oppure eseguire un inline di una classe sono alcune delle mosse di refactoring utilizzate per eliminare questo smell.

## Behaviour Change
Il  "behaviour" o "comportamento" è direttamente e strettamente legato al problema da risolvere. Una regola di business è un comportamento e non varia al variare dei dati.
Ad esempio, un’organizzazione può avere una politica per offrire ai clienti che spendono $5.000 in un anno solare uno sconto sugli acquisti una volta raggiunta tale soglia. La regola potrebbe essere:

> Se un cliente spende più di <soglia_in_divisa> in un <periodo_di_tempo>, allora offrire uno sconto del <sconto_da_applicare>% su ogni elemento.

Questa regola è sempre valida indipendentemente dal periodo e da quanto spende il cliente: quello che potrà variare sono:
- le soglie di spesa
- il periodo nel quale calcolare la soglia
- la percentuale di sconto applicata.

La regola è il _comportamento_; soglie, periodo e percentuali di sconto sono i _dati_. Come accade nel mondo reale, anche nel nostro programma, è bene che _comportamenti_ e _dati_ siano separati. Questo perché i _dati_ possono _cambiare_, proprio come cambiano le soglie che attivano sconti diversi nell'esempio, ma il _comportamento_ resta _invariato_ rispetto ai dati.

## FizzBuzz
Il FizzBuzz è un problema classico, molto spesso utilizzato durante i colloqui tecnici.
La richiesta è semplice:

> Stampare un intero da 1 a N, stampando:
> - "Fizz" se il numero è divisibile per 3;
> - "Buzz" se il numero è multiplo di 5
> - "FizzBuzz" se il numero è divisibile sia per 3 che per 5

Ci sono diverse strade per raggiungere l'obiettivo, ma alcune sono migliori di altre.
Le soluzioni migliori non si limitano a "funzionare", ma rispettano i principi della "buona programmazione", sono aperte al cambiamento e adottato i punti di forza del linguaggio utilizzato.

## Struttura del repository
Il repository presenta due branch:
- **main**: il branch principale nonché il punto di partenza della sfida
- **target**: il punto di arrivo della sfida o quello al quale ispirarsi

Sono presenti i sorgenti per diversi linguaggi di programmazione:
- **Java**: linguaggio orientato agli oggetti, main stream, che trova applicazione in una vasta serie di ambienti. Java è utilizzato dagli smartphone agli ambienti distribuiti, passando anche in IoT.
- **C# (C-Sharp)**: linguaggio orientato agli oggetti creato da Microsoft, che unisce la potenza computazione di *C++*, la facilità di programmazione di *Visual Basic* e diverse feature di *Java*
- **Kotlin**: linguaggio di programmazione orientato agli oggetti, staticamente tipizzato, gira sulla Java Virtual Machine (JVM) e completamente interoperabile con Java. Creato da Jet Brains, è un lignuaggio moderno che unisce molte delle feature più amate di linguaggi come Java, Ruby, Scala, etc.
- **typescript**: linguaggio di programmazione orientato agli oggetti, staticamente tipizzato e compilato. *“TypeScript is JavaScript for application-scale development.”*

## Challenge
Come sviluppatore, ho sempre avuto difficoltà a scrivere codice in cui i _behaviour_ e i dati sono disaccoppiati. Il TDD mi ha aiutato solo in piccola parte e, solitamente, mi ritrovavo a fare _refactor_ per disaccoppiare i _behaviour_ dai dati.
La difficoltà più grossa che incontro facendo _refactor_ è fare "piccoli passi" incrementali che non rompono i test. Nel 2019 mi sono messo a studiare tecniche e metodi di _refactor_ e inizialmente faticavo molto a fare i _refactor_ in piccoli passi e mi sono un po' demoralizzato. Alla conferenza Agile Venture Firenze ho visto Massimo Iacolare che faceva proprio quello che io non riuscivo e questo mi ha dato forza e motivazione per impegnarmi a migliorare.

Sempre nel 2019 ho iniziato a fare il coach tecnico, scoprendo che le mie difficoltà erano abbastanza comuni e ho trovato un "hook" per aiutare gli altri battere il "boss monster" del _refactor_! Ci vuole una motivazione così grande che solo una sfida ti può dare e nelle sessioni di coaching ho iniziato a proporre sfide di refactor del tutto simili a questa.

In cosa consiste la sfida?
Trasformare il codice iniziale in una versione __target__ predefinita, tramite semplici e piccoli passi di refactor. Ogni volta che viene modificata una riga i test devono rimanere verdi e il codice appena scritto deve sostituire la precedente versione il prima possibile, andando effettivamente in produzione. Facciamo un commit per ogni mossa di _refactor_ che porta valore al codice e che sia "unitaria". Ogni commit può essere una singola riga di codice oppure più righe e chi riesce a fare più commit vince! Ogni commit che non porta valore non viene contato, mentre se un commit rompe dei test vale -10.

__Lo spirito del Agile O'Day è la condivisione e discussione NON la competizione__. Alla fine di questo workshop non conteremo i commit e non redigeremo un classifica, ma proveremo a fare il _refactor_ tutti assieme in __mob programming__.

Il carattere di sfida rimane, ma al posto di essere contro gli altri partecipanti sarà contro se stessi! Vi assicuro che fare _refactor_ a "piccoli passi" non è cosa banale e rendersi conto che è possibile e riuscire a farlo per la prima volta è una grande vittoria che può fornire la motivazione per provare a farlo quotidianamente.
