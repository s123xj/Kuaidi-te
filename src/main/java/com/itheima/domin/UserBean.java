package com.itheima.domin;

import com.itheima.dao.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean extends User{

    private User user;
    private List<Map<Object, Object>> shuju;
}
