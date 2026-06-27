FLOW of Project 

![img.png](img.png)

Database Diagram

![img_1.png](img_1.png)

Class Diagram

![img_2.png](img_2.png)

Complete flow of project (Vehicle Arrives)
-------------------------------------------

Vehicle Arrives  --> ParkingService.checkIn() --> ParkingSpotManagerService.getAvailableSpot()

--> ParkingSpotManagerService.allocateSpot() --> ParkingSpot.occupy()

--> ParkingTransactionService.createTransaction() --> ParkingTransaction Returned

(Vehicle Exits)
----------------

ParkingService.checkOut() --> TransactionService.getActiveTransaction()

--> HourlyFeeStrategy.calculateFee() --> Transaction.completeTransaction()

--> SpotManager.releaseSpot() --> ParkingSpot.release()