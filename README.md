# HW3
JDBC URL:jdbc:h2:mem:testdb
Account:sa
Password:12345

在resources中建立一個file: data.sql
INSERT 資料進h2資料庫

Service:

    1.getAllOrders():
      取得所有儲存在DB中的所有訂單
    
    2.getOrderById(int seq):
      根據id去對應DB中的訂單id去做刪除
      
    3.CreateOrder():
      建立新的訂單並儲存至DB中

    4.updateOrder(int seq, Order order):
      根據訂單id去對應DB中的訂單id去做waiter,
      totalPrice,mealList的資料值進行改動
      (參考Controller Package中的UpdateOrderRequest)

    5.deleteOrder(int seq):(失敗!!)
      根據訂單id去對應DB中的訂單id去做刪除
