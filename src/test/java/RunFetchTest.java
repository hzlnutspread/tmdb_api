import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunFetchTest {
    @Test
    void returnsDataObject() {
        var fetcher = new RunFetch();
        assertNotNull(fetcher.getData(1));
    }
}