package jp.co.sss.sys.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MyPageUpdateForm {
    /**
     * 社員の名前
     */
    @NotBlank(message = "名前は入力必須項目です。")
    @Size(max = 16, message = "名前は16文字以内で入力してください。")
    private String empName;
    /**
     * パスワード
     */
    @NotBlank(message = "パスワードは入力必須項目です。")
    @Size(max = 16, message = "パスワードは16文字以内で入力してください。")
    private String password;
    /**
     * 生年月日
     */
    @NotBlank(message = "生年月日は入力必須項目です。")
    private String birthday;
}
