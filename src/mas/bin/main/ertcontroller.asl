
!start.

+!start
    <- .wait(1000);
       .print("Checking the Property ");
       checkEmpty;
       checkAngle;
       checkPositionY;
       !control.
+!control
    : (empty(Y) & Y == true & angle(X) & X = 0 & positionY(Z) & Z = 0) 
    <-
    .print("Attending the RawPlate"); 
    .send(feedbelt,achieve,doRequest);
    .wait({+!activeERT});
    .print("Transfert RawPlate");
    transferTo;
    checkEmpty;
    checkAngle;
    checkPositionY;
    !control.
+!control
     : angle(X) & X < 100 & empty(Y) & Y = false
     <- 
     .wait(900);
     .print("Rotate to 100 Angle");
      rotate;
      checkEmpty;
      checkAngle;
      checkPositionY;
      !control.
+!control
    : positionY(X) & X < 10 & empty(Y) & Y = false
    <-
    .wait(400);
    .print("Up");
    up;
    checkPositionY;
    checkEmpty;
    !control.
+!control
    : empty(Y) & Y = true & angle(X) & X >= 100 
    <-
    .wait(900);
    .print("Rotate to 0 Angle");
    rotate;
    checkEmpty;
      checkAngle;
      checkPositionY;
    !control.
+!control
    : empty(Y) & Y = true & angle(X) & X = 0 & positionY(Z) & Z <= 10
    <-
    .wait(400);
    .print("Down");
    down;
    checkPositionY;
    checkEmpty;
    !control.
+!control
    : empty(Y) & Y = false & angle(X) & X = 100 & positionY(Z) & Z = 10
    <- .print("Input Robot");
    .send(robot,achieve,pickFromERT);
    .send(robot,achieve,activateRobot);
    .wait(3000);
     checkEmpty;
    checkAngle;
    checkPositionY;
    !control.
+!control 
    <-
    .wait({+!activeERT});
    checkEmpty;
    checkAngle;
    checkPositionY;
    !control.
+!activeERT
    <-  .print("Input Received");.
    


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }