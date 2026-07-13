package accountpl.account;

import accountpl.account.core.resource.AccountResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class AccountResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(AccountResourceFactory.class.getName());

    public AccountResourceFactory() {}

    public static AccountResource createAccountResource(String fullyQualifiedName, Object ... base) {
        AccountResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (AccountResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of AccountResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to AccountResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating AccountResource.");
            System.exit(50);
        }
        return record;
    }
}
