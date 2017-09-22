# Ventaja
###### An approach of faster test data creation.
`Verify gains against real data`
- Michael T. Nygard, 'Release it!' p.165 version 5.1 August 2012

In most projects, the data used for testing contains:
 - exactly the data needed.
 - a (most times) anonymised production dump.
 
Both solution have drawbacks. In the first case, db statements can perform fine on test data and waste tons of time, when the data grows. The second approach has the obvious problem with privacy, if not correctly anonymised. Also it's for example sometimes not a good approach to dump a database, when the data flow uses the same connection than the productive traffic.   

With **Ventaja**, an approach should be tested to create test data which:
- can include randomised and fixed data (You know, these two users for the testcases...)
- can be exported in import-ready files (csv, impex, json, maybe sql)
- can contain a lot of data structures by configurable attributes