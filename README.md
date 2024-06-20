# Certificate Generator Project

This project demonstrates the performance comparison of different data structures (ArrayList, LinkedList, HashMap, TreeMap) by generating certificates with a background and exporting them as JPEG images. The project is implemented in Java.

## Problem

The objective is to test and compare the performance (time and space complexity) of different data structures when generating certificates for varying numbers of names.

## Solution

We implemented the following data structures and algorithms to generate certificates:
- **Data Structures**: ArrayList, LinkedList, HashMap, TreeMap
- **Algorithm**: Certificate generation with a background and a name, exported as JPEG

## Performance Comparison

### Results

#### For `n = 10`:

| Data Structure | Average Time Taken (ns) | Average Space Taken (bytes) |
|----------------|-------------------------|-----------------------------|
| ArrayList      | 489,460,080             | 67,136                      |
| LinkedList     | 251,916,160             | 28,440                      |
| HashMap        | 234,061,660             | 18,696                      |
| TreeMap        | 221,272,320             | 12,232                      |

#### For `n = 100`:

| Data Structure | Average Time Taken (ns) | Average Space Taken (bytes) |
|----------------|-------------------------|-----------------------------|
| ArrayList      | 2,502,191,960           | 67,136                      |
| LinkedList     | 2,193,069,000           | 53,595                      |
| HashMap        | 2,176,464,340           | 21,467                      |
| TreeMap        | 2,166,783,000           | 12,432                      |

#### For `n = 1000`:

| Data Structure | Average Time Taken (ns) | Average Space Taken (bytes) |
|----------------|-------------------------|-----------------------------|
| ArrayList      | 18,127,563,180          | 170,640                     |
| LinkedList     | 17,807,245,880          | 95,200                      |
| HashMap        | 18,011,805,360          | 109,768                     |
| TreeMap        | 17,743,490,580          | 87,730                      |

### Conclusion

**Best Data Structure: TreeMap**

- **Performance (Time Taken)**: TreeMap performs the best in terms of time taken for larger datasets (`n = 1000`).
- **Memory Usage (Space Taken)**: TreeMap consistently uses the least memory across all dataset sizes.
- **Scalability**: TreeMap scales well with increasing dataset sizes.

**Recommendation**:
- **TreeMap**: Efficient performance and low memory usage, suitable for sorted data.
- **HashMap**: Fast lookups, suitable for unordered data.
- **LinkedList**: Frequent insertions/deletions but may suffer performance issues with large datasets.
- **ArrayList**: Fast random access but higher memory usage and slower performance with large datasets.

## How to Run the Project

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/certificate-generator.git
    ```
2. Navigate to the project directory:
    ```bash
    cd certificate-generator
    ```
3. Compile the Java files:
    ```bash
    javac -d bin src/*.java
    ```
4. Run the main program:
    ```bash
    java -cp bin Main
    ```

## Project Structure

```
.
├── src
│ ├── CertificateGenerator.java
│ ├── Main.java
│ └── ... (other Java files)
├── bin
│ └── ... (compiled class files)
├── certificates
│ └── ... (generated certificates)
└── README.md
```


## Dependencies

- Java Development Kit (JDK) 8 or higher
- Libraries: None

## Future Work

- Test with larger datasets (`n = 10,000` and beyond)
- Optimize certificate generation process
- Implement additional data structures for comparison

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
