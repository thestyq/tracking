package ts.tracking;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by styqq on 28.03.16.
 */
public class DataCollectorTest {

    private DataCollector testee;

    @Mock
    private TrackingDB dbMock;

    @Before
    public void setUp() {
        testee = new DataCollector();
        testee.setDb(dbMock);
    }

    @Test
    public void visit_shouldRecordNewVisit_whenVisitNotInDb() {

    }

    @Test
    public void visit_shouldExtendOldVisit_whenVisitInDb() {

    }

    @Test
    public void wisit_should(){

    }
}
