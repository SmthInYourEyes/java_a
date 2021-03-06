package ru.stqa.pft.addressbok.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.GroupData;
import ru.stqa.pft.addressbok.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test0"));
        }
    }

    @Test()
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() -1));
        Groups after = app.group().all();
        assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));
    }
}





