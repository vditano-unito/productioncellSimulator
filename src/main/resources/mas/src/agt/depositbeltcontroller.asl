!start.

+!start
    <- .print("[DEPOSITBELT] Checking the Property ");
        checkDepositBelt;
        !control.

+!control
    : empty(X) & X = false
    <- .print("[DEPOSITBELT] MetalPlate Stored"); 
    storeMetalPlate;
    checkDepositBelt;
    !control.

+!control
    <- .print("[DEPOSITBELT] Waiting");
        .wait({+!activateDepositBelt});
        .wait(3000);
       checkDepositBelt;
        !control.

+!activateDepositBelt
    <-  .print("Input Received");.
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }