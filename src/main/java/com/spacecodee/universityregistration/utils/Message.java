package com.spacecodee.universityregistration.utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message<E>{
    private String message;
    private E data;
}
