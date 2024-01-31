package com.practiceproject1.simpleapi.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.practiceproject1.simpleapi.user.Permissions.*;

@RequiredArgsConstructor
public enum Roles {
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_CREATE,
                    ADMIN_DELETE
            )
    ),
    STUDENT(
            Set.of(
                    STUDENT_READ,
                    STUDENT_UPDATE,
                    STUDENT_CREATE,
                    STUDENT_DELETE
            )
    );
    @Getter
    private final Set<Permissions> permissions;
}
