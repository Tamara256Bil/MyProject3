public class AbstractTest {
    public abstract class AbstractTest {

        private static WebDriver driver;

        @BeforeAll
        static void init(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        @BeforeEach
        void goTo(){
            Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.vstu.ru"),
                    "Страница не доступна");
        }



        @AfterAll
        static void close(){
            //driver.quit();
        }

        public static WebDriver getDriver() {
            return driver;
        }
}
