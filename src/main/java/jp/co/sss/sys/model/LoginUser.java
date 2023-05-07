package jp.co.sss.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginUser implements Serializable {
     private String username;
}
