package lotto.domain;

public enum ErrorMessage {
    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT("유효하지 않은 구매 금액입니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    DUPLICATE_NUMBERS("중복된 숫자는 입력할 수 없습니다."),
    INVALID_BONUS_NUMBER("유효하지 않은 보너스 번호입니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
