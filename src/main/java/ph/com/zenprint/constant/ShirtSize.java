package ph.com.zenprint.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Choy
 * @date 4/19/2021.
 */
@RequiredArgsConstructor
@Getter
public enum ShirtSize {

    XS("Extra Small"),
    S("Small"),
    M("Medium"),
    L("Large"),
    XL("Extra Large"),
    XXL("2XL");

    private final String name;
}
