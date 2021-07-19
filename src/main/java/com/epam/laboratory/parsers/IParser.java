package com.epam.laboratory.parsers;

import com.epam.laboratory.workObjects.DiamondFund;

import java.io.File;

public interface IParser {
    DiamondFund parse(File file);
}
