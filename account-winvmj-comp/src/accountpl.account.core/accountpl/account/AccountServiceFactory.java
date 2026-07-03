package accountpl.account;

import accountpl.account.core.service.AccountService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class AccountServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(AccountServiceFactory.class.getName());

    public AccountServiceFactory() {}

    public static AccountService createAccountService(String fullyQualifiedName, Object ... base) {
        AccountService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (AccountService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of AccountService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to AccountService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating AccountService.");
            System.exit(50);
        }
        return record;
    }
}
