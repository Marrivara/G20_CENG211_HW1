package BusinessLayer;

public class SalesQuery {

   SalesManagement salesManagement;

   public SalesQuery(SalesManagement salesManagement) {
      this.salesManagement = salesManagement;
   }

   public void calculateTheOutputs(){
	  mostProfitableProduct();											  // Question 1
      mostExpensiveProduct();											  // Question 2
      System.out.println(calculateMaxNumberOfPurchase().toString());      // Question 3	 											   
      totalProfit();													  // Question 4
      leastProfitS1();													  // Question 5
   }
   
   // Question 1: Most profitable product with data
   public void mostProfitableProduct() {
	   double mostProfit = 0;
	   Product profProduct = null;
	   
	   for (int i = 0; i<3; i++) {
		   for (int j = 0; j<40; j++) {
			   if(salesManagement.getSales(i,j) == null){
	               break;
	            }
			   if(salesManagement.getSales(i, j).getSalesPrice() - salesManagement.getSales(i, j).getProduct().getPrice() > mostProfit) {
				   mostProfit = salesManagement.getSales(i, j).getSalesPrice() - salesManagement.getSales(i, j).getProduct().getPrice();
				   profProduct = salesManagement.getSales(i, j).getProduct();
			   }
		   }
	   }
	   System.out.println(profProduct.toString() + " -> " + mostProfit + " TL profit");
   }

   
   // Question 2: Most expensive product with data
   
   public void mostExpensiveProduct() {
	   double mostExpensive = 0;
	   Product mostExProduct = null;
	   
	   for (int i = 0; i<3; i++) {
		   for (int j = 0; j < 40; j++) {
			   if(salesManagement.getSales(i,j) == null){
	               break;
			   }
			   if(salesManagement.getSales(i, j).getSalesPrice() > mostExpensive) {
				   mostExpensive = salesManagement.getSales(i, j).getSalesPrice();
				   mostExProduct = salesManagement.getSales(i, j).getProduct();
			   }
		   }
	   }
	   System.out.println(mostExProduct.toString() + " -> with sales price " + mostExpensive + " TL");
   }
   
   // Question 3: The customer who purchases the most products
   public Customer calculateMaxNumberOfPurchase(){
      int max = 0;
      Customer maxCustomer = null;
      for(int i = 0; i<3; i++){
         for (int j = 0; j<40;j++){
            if(salesManagement.getSales(i,j) == null){
               break;
            }
            if (salesManagement.getSales(i,j).getCustomer().getNumberOfPurchases()>max){
               maxCustomer = salesManagement.getSales(i,j).getCustomer();
            }

         }
      }
      return maxCustomer;
   }


   // Question 4: The total profit that is made from all sales
   public void totalProfit() {
	   long totalProfit = 0;
	   
	   for (int i = 0; i<3; i++) {
		   for (int j=0; j<40; j++) {
			   if(salesManagement.getSales(i,j) == null){
	               break;
			   }
			   // Profit = SalesPrice - Price
			   totalProfit += salesManagement.getSales(i, j).getSalesPrice() - salesManagement.getSales(i, j).getProduct().getPrice();
		  } 
	   }
	   System.out.println(totalProfit + " TL");
   }
   
   // Question 5: The least-profit product of S1
   
   public void leastProfitS1() {
	   
	   // At first, we have to take a product to compare reference
	   // Our compare reference -> First product of S1
	   
	   Product leastProfProduct = salesManagement.getSales(0, 0).getProduct();
	   double leastProfit = salesManagement.getSales(0, 0).getSalesPrice() - salesManagement.getSales(0, 0).getProduct().getPrice();
	   for (int i=1; i<40; i++) {
		   if(salesManagement.getSales(0,i) == null){
               break;
		   }
		   if(salesManagement.getSales(0, i).getSalesPrice() - salesManagement.getSales(0, i).getProduct().getPrice() < leastProfit) {
			   leastProfit = salesManagement.getSales(0, i).getSalesPrice() - salesManagement.getSales(0, i).getProduct().getPrice();
			   leastProfProduct = salesManagement.getSales(0, i).getProduct();
		   }
	   }
	   System.out.println(leastProfProduct.toString() + " -> " + leastProfit + " TL profit");
   }
}
