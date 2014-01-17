package com.lostcreations.mojo.branchver;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.lostcreations.mojos.branchver.BranchName;

public class BranchNameTest
{
    @Test
    public void parseHotfixBranchTest()
    {
        BranchName bn = BranchName.parse("hotfix/test");
        Assert.assertTrue(bn.isTyped());
        Assert.assertEquals(bn.getName(), "test");
        Assert.assertEquals(bn.getType(), "hotfix");
        Assert.assertEquals(bn.toString(), "hotfix/test");
    }

    @Test
    public void parseDevelopBranchTest()
    {
        BranchName bn = BranchName.parse("develop");
        Assert.assertFalse(bn.isTyped());
        Assert.assertEquals(bn.getName(), "develop");
        Assert.assertEquals(bn.getType(), null);
        Assert.assertEquals(bn.toString(), "develop");
    }

    @Test
    public void parseRefsHeadsMasterBranchTest()
    {
        BranchName bn = BranchName.parse("refs/heads/master");
        Assert.assertFalse(bn.isTyped());
        Assert.assertEquals(bn.getName(), "master");
        Assert.assertEquals(bn.getType(), null);
        Assert.assertEquals(bn.toString(), "master");
    }

    @Test
    public void parseRefsHeadsFeatureBranchTest()
    {
        BranchName bn = BranchName.parse("refs/heads/feature/test");
        Assert.assertTrue(bn.isTyped());
        Assert.assertEquals(bn.getName(), "test");
        Assert.assertEquals(bn.getType(), "feature");
        Assert.assertEquals(bn.toString(), "feature/test");
    }
}
