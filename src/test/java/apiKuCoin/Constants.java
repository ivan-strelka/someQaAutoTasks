package apiKuCoin;

public class Constants {

    public static class Currency {
        public static final String USDT = "USDT";
        public static final String LOVE_USDT = "LOVE-USDT";
    }

    public static class EndPoints {

        public static final String ALL_TICKERS = "https://api.kucoin.com/api/v1/market/allTickers";
        public static final String PARAM_TICKERS = "https://api.kucoin.com/api/v1/market/%s";

        public static String getParamAllTickers(String param) {
            return String.format(PARAM_TICKERS, param);
        }

    }

}
