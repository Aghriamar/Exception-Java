import java.io.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Введите данные (Фамилия Имя Отчество Дата_рождения Номер_телефона Пол): ");
                String input = reader.readLine();
                UserData userData = UserDataParser.parse(input);
                UserFileWriter.writeUserData(userData);
            } catch (IOException e) {
                System.err.println("Ошибка ввода/вывода: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            } catch (ParseException e) {
                System.err.println("Ошибка при парсинге даты: " + e.getMessage());
            }
        }
    }
}

/**
 * Класс UserData представляет информацию о пользователе.
 */
class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String phoneNumber;
    private String gender;

    /**
     * Конструктор создает объект UserData с заданными данными.
     *
     * @param lastName     Фамилия пользователя.
     * @param firstName    Имя пользователя.
     * @param middleName   Отчество пользователя.
     * @param birthDate    Дата рождения пользователя в формате "dd.mm.yyyy".
     * @param phoneNumber  Номер телефона пользователя (целое беззнаковое число).
     * @param gender       Пол пользователя ("f" - женский, "m" - мужской).
     */
    public UserData(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    /**
     * Получить фамилию пользователя.
     *
     * @return Фамилия пользователя.
     * @throws IllegalArgumentException Если фамилия не соответствует формату.
     */
    public String getLastName() {
        if (!isValidName(lastName) || !isValidName(firstName) || !isValidName(middleName)) {
            throw new IllegalArgumentException("Неверный формат имени, фамилии или отчества.");
        }
        return lastName;
    }

    /**
     * Получить имя пользователя.
     *
     * @return Имя пользователя.
     * @throws IllegalArgumentException Если имя не соответствует формату.
     */
    public String getFirstName() {
        if (!isValidName(lastName) || !isValidName(firstName) || !isValidName(middleName)) {
            throw new IllegalArgumentException("Неверный формат имени, фамилии или отчества.");
        }
        return firstName;
    }

    /**
     * Получить отчество пользователя.
     *
     * @return Отчество пользователя.
     * @throws IllegalArgumentException Если отчество не соответствует формату.
     */
    public String getMiddleName() {
        if (!isValidName(lastName) || !isValidName(firstName) || !isValidName(middleName)) {
            throw new IllegalArgumentException("Неверный формат имени, фамилии или отчества.");
        }
        return middleName;
    }

    /**
     * Получить дату рождения пользователя в формате "dd.mm.yyyy".
     *
     * @return Дата рождения пользователя.
     * @throws IllegalArgumentException Если дата рождения не соответствует формату.
     */
    public String getBirthDate() {
        if (!isValidBirthDate(birthDate)) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается dd.mm.yyyy.");
        }
        return birthDate;
    }

    /**
     * Получить номер телефона пользователя (целое беззнаковое число).
     *
     * @return Номер телефона пользователя.
     * @throws IllegalArgumentException Если номер телефона не соответствует формату.
     */
    public String getPhoneNumber() {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое беззнаковое число.");
        }
        return phoneNumber;
    }

    /**
     * Получить пол пользователя ("f" - женский, "m" - мужской).
     *
     * @return Пол пользователя.
     * @throws IllegalArgumentException Если пол не соответствует формату.
     */
    public String getGender() {
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Неверный формат пола. Ожидается 'f' или 'm'.");
        }
        return gender;
    }

    /**
     * Проверить, что заданное имя соответствует формату (состоит только из букв).
     *
     * @param name Имя для проверки.
     * @return true, если имя соответствует формату, в противном случае - false.
     */
    public static boolean isValidName(String name) {
        // Проверка, что имя состоит только из букв
        return name.matches("^[a-zA-Zа-яА-Я]+$");
    }

    /**
     * Проверить, что заданная дата рождения соответствует формату "dd.mm.yyyy".
     *
     * @param birthDate Дата рождения для проверки.
     * @return true, если дата рождения соответствует формату, в противном случае - false.
     */
    public static boolean isValidBirthDate(String birthDate) {
        // Проверка, что дата рождения имеет формат dd.mm.yyyy
        return birthDate.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$");
    }

    /**
     * Проверить, что заданный номер телефона соответствует формату (состоит только из цифр).
     *
     * @param phoneNumber Номер телефона для проверки.
     * @return true, если номер телефона соответствует формату, в противном случае - false.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Проверка, что номер телефона состоит только из цифр
        return phoneNumber.matches("^\\d+$");
    }

    /**
     * Проверить, что заданный пол соответствует формату ("f" - женский, "m" - мужской).
     *
     * @param gender Пол для проверки.
     * @return true, если пол соответствует формату, в противном случае - false.
     */
    public static boolean isValidGender(String gender) {
        // Проверка, что пол - 'f' или 'm'
        return gender.equals("f") || gender.equals("m");
    }
}

/**
 * Класс UserDataParser предназначен для разбора входной строки и создания объекта UserData.
 */
class UserDataParser {
    /**
     * Метод разбирает входную строку и создает объект UserData.
     *
     * @param input Входная строка с данными пользователя.
     * @return Объект UserData с разобранными данными.
     * @throws IllegalArgumentException Если количество данных не соответствует требуемому.
     */
    public static UserData parse(String input) throws IllegalArgumentException, ParseException {
        String[] data = input.split(" ");

        if (data.length != 6) {
            throw new IllegalArgumentException("Количество данных не соответствует требуемому");
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        return new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }
}

/**
 * Класс UserFileWriter предназначен для записи данных о пользователе в файл.
 */
class UserFileWriter {
    /**
     * Метод записывает данные о пользователе в файл.
     *
     * @param userData Объект UserData с данными пользователя.
     * @throws IOException Если произошла ошибка при записи данных в файл.
     */
    public static void writeUserData(UserData userData) throws IOException {
        String fileName = userData.getLastName() + ".txt";
        String fileContent = userData.getLastName() + " " + userData.getFirstName() + " " + userData.getMiddleName() +
                " " + userData.getBirthDate() + " " + userData.getPhoneNumber() + " " + userData.getGender();

        try (Writer writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(fileContent + "\n");
            writer.flush();
            System.out.println("Данные успешно записаны в файл.");
        }catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}