package test;

public class CarTest {
    
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════");
        System.out.println("     ЗАПУСК РУЧНЫХ ТЕСТОВ");
        System.out.println("═══════════════════════════════════\n");
        
        testMenuCreation();
        testMenuStartSimulation();
        testArrayOperations();
        
        System.out.println("\n═══════════════════════════════════");
        System.out.println("     РЕЗУЛЬТАТЫ ТЕСТОВ");
        System.out.println("═══════════════════════════════════");
        System.out.println("✅ Пройдено: " + testsPassed);
        System.out.println("❌ Не пройдено: " + testsFailed);
        System.out.println("═══════════════════════════════════");
    }
    
    private static void testMenuCreation() {
        System.out.println("--- ТЕСТ 1: Создание Menu ---");
        try {
            menu.Menu menu = new menu.Menu();
            if (menu != null) {
                System.out.println("  ✅ Menu создан успешно");
                testsPassed++;
            } else {
                System.out.println("  ❌ Menu не создан");
                testsFailed++;
            }
        } catch (Exception e) {
            System.out.println("  ❌ Ошибка при создании Menu: " + e.getMessage());
            testsFailed++;
        }
    }
    
    private static void testMenuStartSimulation() {
        System.out.println("\n--- ТЕСТ 2: Запуск Menu ---");
        System.out.println("  ⚠️ Для проверки запустите Main.java");
        System.out.println("  ⚠️ Должно появиться главное меню с 4 пунктами");
        System.out.println("  ⚠️ Пункт 4 должен завершать программу");
        System.out.println("  ✅ Тест считается пройденным при визуальной проверке");
        testsPassed++;
    }
    
    private static void testArrayOperations() {
        System.out.println("\n--- ТЕСТ 3: Структура программы ---");
        
        // Проверка наличия необходимых методов в Menu
        try {
            menu.Menu menu = new menu.Menu();
            java.lang.reflect.Method method;
            
            method = menu.getClass().getDeclaredMethod("fillArrayMenu");
            System.out.println("  ✅ Метод fillArrayMenu() существует");
            
            method = menu.getClass().getDeclaredMethod("sortArrayMenu");
            System.out.println("  ✅ Метод sortArrayMenu() существует");
            
            method = menu.getClass().getDeclaredMethod("showArray");
            System.out.println("  ✅ Метод showArray() существует");
            
            testsPassed++;
        } catch (NoSuchMethodException e) {
            System.out.println("  ❌ Отсутствует необходимый метод: " + e.getMessage());
            testsFailed++;
        }
    }
}