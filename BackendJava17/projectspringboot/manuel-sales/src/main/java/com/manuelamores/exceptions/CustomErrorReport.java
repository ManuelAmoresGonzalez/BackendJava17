package com.manuelamores.exceptions;

import java.time.LocalDateTime;

public record CustomErrorReport(

        LocalDateTime dateTime,
        String message,
        String path
) {
}
