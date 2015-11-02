Si scriva un programma che permetta di gestire dei conti bancari attraverso una banca.
Ogni conto e' caratterizzato da un proprietario (identificato dal suo CF), un iban e un saldo. I conti possono essere di tre tipi:
1) conto corrente: dove si puo' prelevare e depositare denaro
2) conto web: come il conto corrente ma richiede di loggarsi tramite una password prima di poter eseguire le operazioni
3) conto deposito: dove si puo' solo depositare (e non prelevare) denaro

---creazione conti
Tutti i conti possono essere aperti tramite la banca comunicando il CF del proprietario e il tipo di conto da aprire. Il saldo iniziale dei conti all'apertura e' sempre 0 e l'iban viene assegnato automaticamente dalla banca. Non possono esistere due conti con lo stesso iban nella stessa banca. 
Per il conto web la password viene inizialmente impostata a "changeme" e puo' essere cambiata con una a scelta al primo accesso al conto. Finche' la password non e' stata cambiata non possono essere fatte operazioni

---operazioni sui conti
Le operazioni sui conti devono essere svolte tramite la banca. La banca contiene 0..n conti dei diversi tipi, ognuno identificato dal suo iban. Su ogni conto deve essere possibile eseguire un'operazione (aggiungere o togliere denaro), richiedere il saldo e richiedere la stampa dei dettagli del conto (CF intestatario, iban e saldo).

---accrediti/domiciliazioni
Ad ogni conto, tramite la banca, e' possibile associare degli (0..n) Accountable. Ogni accountable definisce una cifra da accreditare (es. uno stipendio) o da pagare (es. un abbonamento pay-tv) alla fine di ogni mese. Sara' compito della banca eseguire l'operazione di fine mese su tutti i conti registrati e scalare/accreditare le cifre definite dalla lista di Accountable associata ad ogni conto.