

!start.

+!start
    <- .wait(1000);
       .print("Checking the Property ");
       checkEmptyArm1;
       checkEmptyArm2;
       checkAngle;
       !robotControl.

+!robotControl //Quando Pick dalla ERT
    : anglerobot(Y) & Y = 90  & emptyarm1(Z) & Z = true & pickERT(X) & X = true
    <-.wait(1000); 
    //.print("Attending the RawPlate and ERT"); 
    setPickERT(false);
    .print("Pick Raw Plate From ERT");
    activateMagnet1;
    .wait(1000);
    checkEmptyArm1;
     .send(ert,achieve,activeERT);
      .wait(1000);
    !robotControl.
+!robotControl //Quando Pick dalla Press
    : anglerobot(Y) & Y = 90  & emptyarm2(Z) & Z = true  & pickPress(X) & X = true
    <-.wait(1000);
    .print("Pick MetalPlate From Press");
    setPickPress(false);
    .send(press,achieve,open);
    .wait(500);
    activateMagnet2;
    .wait(500);
    .send(press,achieve,close);
    checkEmptyArm2;
     .wait(1000);
    !robotControl.
+!robotControl
    : anglerobot(Y) & Y > 0 & (emptyarm1(X) & X = false |  emptyarm2(Z) & Z = false) 
    <- .wait(1000);
    .print("Rotate Up");
    rotateUp;
    checkAngle;
    !robotControl.

+!robotControl //Deposito
    : anglerobot(Y) & Y = 0 & emptyarm2(X) & X = false 
    <- .wait(1000);
    .print("MetalPlate in The DepositBelt");
    activateMagnet2;
    .send(depositbelt,achieve,activateDepositBelt);
    checkEmptyArm2;
    !robotControl.
+!robotControl // Rilascio nella press
    :  anglerobot(Y) & Y = 0 & emptyarm1(X) & X = false 
    <-
   .send(press,achieve,open);
   .wait(500);
    activateMagnet1;
    .wait(500);
    .send(press,achieve,close);
    checkEmptyArm1;
    .send(press,achieve,activatePress);
    !robotControl.
+!robotControl
    : anglerobot(Y) & Y = 90  & emptyarm2(Z) & Z = true  & emptyarm1(X) & X = true
    <-.print("Waiting "); 
    .wait(3000);
    checkEmptyArm1;
    checkEmptyArm2;
    checkAngle;
    !robotControl.
+!robotControl
    : anglerobot(Y) & Y >=0 & emptyarm2(X) & X = true  & emptyarm1(Z) & Z = true 
    <- .wait(1000);
    .print("Rotate Down");
    rotateDown;
    checkAngle;
    !robotControl.


+!activateRobot
    <-  .print("Input Received");.

+!pickFromPress
    <- setPickPress(true).
+!pickFromERT
    <- setPickERT(true).
    


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }


/*

+!robotControl //Quando Pick dalla Press
    : anglerobot(Y) & Y = 90  & emptyarm2(Z) & Z = true 
    <-.wait(1000);
    .print("Pick From Press");
    .send(press,achieve,open);
    .wait(1000);
    activateMagnet2;
    .wait(1000);
    .send(press,achieve,close);
    checkEmptyArm2;
    !robotControl.



 getObsProperty("running").booleanValue()
    */