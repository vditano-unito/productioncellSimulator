!start.

+!start
    <- .print("Checking the Property ");
        checkSupply;
        checkFeedBelt;
        !controlFeedBelt.

+!controlFeedBelt
    : empty(X) & X = true & supply(Y) & Y = false
    <-  .print("AddRawPlate in The FeedBelt");
        addRawPlate;
        .wait(1500);
        checkSupply;
        checkFeedBelt;
        !controlFeedBelt.
+!controlFeedBelt
    : request(Z) & Z = true & empty(X) & X = false
    <- .print("Transfer RawPlate into ERT");
        setRequest(false);
        .wait(1000);
        .send(ert,achieve,activeERT);
        
        checkSupply;
        checkFeedBelt;
        !controlFeedBelt.

+!controlFeedBelt
    <- .print("Waiting");
        .wait(5000);
        checkSupply;
        checkFeedBelt;
        !controlFeedBelt.

+!doRequest
    <- setRequest(true);.


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
