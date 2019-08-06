package sfa.classification.weaselCharacterClassifier;

import java.util.ArrayList;
import java.util.List;

import sfa.classification.AbstractClassifierTest;
import sfa.classification.Classifier;
import sfa.classification.WEASELCharacterClassifier;
import subwordTransformer.cng.CNGParameter;
import subwordTransformer.cng.CNGTransformer;

public class CNGClassifierTest extends AbstractClassifierTest {
  @Override
  protected List<DataSet> getDataSets() {
    List<DataSet> dataSets = new ArrayList<>();

    dataSets.add(new DataSet("variable_length", 0.929, 0.964));
    dataSets.add(new DataSet("Coffee", 1.0, 1.0));
    dataSets.add(new DataSet("Beef", 0.967, 0.867));
    dataSets.add(new DataSet("CBF", 0.967, 0.992));

    return dataSets;
  }

  @Override
  protected Classifier initClassifier() {
    WEASELCharacterClassifier.transformer = new CNGTransformer(WEASELCharacterClassifier.maxS, true);
    WEASELCharacterClassifier.transformerParameterList = new ArrayList<>(CNGParameter.getParameterList(2, 2, 4, 4, 0.5, 0.5, 1));
    return new WEASELCharacterClassifier();
  }

}