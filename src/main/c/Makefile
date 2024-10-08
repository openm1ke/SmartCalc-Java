CC=gcc
CFLAGS=-fPIC -Wall -Werror -Wextra
LDFLAGS=-shared
LIBRARY=libmath_library.so
LIBS=-lm
SRC_FILE=math_library.c

all: $(LIBRARY) clean

$(LIBRARY): $(SRC_FILE)
	$(CC) $(CFLAGS) $(LDFLAGS) -o $(LIBRARY) $(SRC_FILE) $(LIBS)
	cp $(LIBRARY) ./../resources

clean:
	rm -rf $(LIBRARY)

.PHONY: all clean
