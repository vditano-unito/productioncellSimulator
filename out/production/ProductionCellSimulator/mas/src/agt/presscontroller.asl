

!start.

+!start
    <- .wait(1000);
       .print("[PRESS] Checking the Property ");
       checkEmpty;
       checkPositionX;
       checkForging;
       checkIsForged;
        !controlPress.


+!controlPress
    : empty(Y) & Y = false & forging(Z) & Z = false & positionX(X) & X = 0 & isForged(W) & W=false    
    <- 
    .print("Forge ");
        forgePlate;
        setCondition;
        .wait(7000);
        .send(robot,achieve,pickFromPress);
        
        .send(robot,achieve,activateRobot);
        !controlPress.
+!controlPress
    <-
     .print("Waiting ");
    
     .wait({+!activatePress});
     .print("Activate Press ");
      checkEmpty;
       checkPositionX;
       checkForging;
       checkIsForged;
         !controlPress.

+!open
    <- 
     .print("Open");
      openPress.
+!close
    <- 
     .print("Close");
      closePress.
+!activatePress
    <-  .print("Input Received");.

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }


