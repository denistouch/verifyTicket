# Счастливый билет 
Простой проект, по своей сути набор из нескольких классов, который позволяет строку и узнать является ли переданная последовательность счастливой, по правилам из детства, когда билетик от тролейбуса мог стать счастливым.

## Методика
На вход принимаем строку, содержащую любой набор символов, подготавливаем её к использованию, для этого удаляем все символы несоответствующие шестнадцатиричной системе счисления после этого делаем строку чётной длинны,
если потребуется, путём добавления нуля в конец последовательности. Делим строку на две равные части и считаем сумму цифр, после этого сравниваем и формируем отчёт.

## Использование
Создайте экземляр класса LuckyTicket передав в него строку => вызовете у него метод calculate => получите отчёт и используйте по своему усмотрению
```java
  LuckyTicket lucky = new LuckyTicket("ga7dsga&*^^#^*()7dagda9dagg1ddff123~**!^#!@");
  LuckyTicket.Report report = lucky.calculate();

  // В результате вы получите всеобъемлющий отчёт, который имеет следующий интерфейс
  public static class Report {
    public Report(@NotNull String original, boolean isValid, int leftSum, int rightSum,@NotNull String prepared)
    private static Report invalid(@NotNull String original)
    public boolean isInvalid()
    public boolean isLucky()
    public int getLeftSum()
    public int getRightSum()
    public String print()
}
```
