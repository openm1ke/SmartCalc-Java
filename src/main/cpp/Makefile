CC=g++
CFLAGS=-Wall -Werror -Wextra
LDFLAGS=-shared
SRC_FILE=math_library.cpp

# Определение ОС
OS := $(shell uname -s 2>/dev/null || echo Windows)

# Настройки для Windows
ifeq ($(OS), Windows)
    LIBRARY=math_library.dll
    CFLAGS += #-m64
    RM=del
    COPY=copy
    TARGET_DIR=..\resources
# Настройки для Linux
else
    LIBRARY=libmath_library.so
    CFLAGS += -fPIC -m64
    RM=rm -rf
    COPY=cp
    TARGET_DIR=../resources
endif

all: $(LIBRARY)

$(LIBRARY):
	$(CC) $(CFLAGS) $(LDFLAGS) -o $(LIBRARY) $(SRC_FILE)
	$(COPY) $(LIBRARY) $(TARGET_DIR)

clean:
	$(RM) $(LIBRARY)

.PHONY: all clean
