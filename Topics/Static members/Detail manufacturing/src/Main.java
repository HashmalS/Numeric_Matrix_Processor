class ManufacturingController {
    static int numberOfProducts = 0;

    public static String requestProduct(String product) {
        return String.format("%d. Requested %s", ++numberOfProducts, product);
    }

    public static int getNumberOfProducts() {
        return numberOfProducts;
    }
}