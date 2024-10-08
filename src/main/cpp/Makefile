CC=g++
CFLAGS=-fPIC -Wall -Werror -Wextra
LDFLAGS=-shared
LIBRARY=libmath_library.so
SRC_FILE=math_library.cpp

all: $(LIBRARY) clean

$(LIBRARY):
	$(CC) $(CFLAGS) $(LDFLAGS) -o $(LIBRARY) $(SRC_FILE)
	cp $(LIBRARY) ./../resources

clean:
	rm -rf $(LIBRARY)

.PHONY: all clean