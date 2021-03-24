package com.pht.common.job;

import com.pht.base.system.constant.SysParam;
import com.pht.common.CommonDict;
import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.common.frame.LoggerFormator;
import com.pht.common.frame.QMENV;
import com.pht.config.utils.SysParamFactory;
import com.pht.contract.constant.ContractDict;
import com.pht.contract.entity.Contractdetails;
import com.pht.contract.entity.ContractdetailsTmp;
import com.pht.contract.service.ContractdetailsService;
import com.pht.contract.service.ContractdetailsTmpService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableScheduling
@Configuration
public class CommJob  {
    private static LoggerFormator logger =LoggerFormator.getLogger(CommJob.class);
    @Autowired
    private ContractdetailsService contractdetailsService;
    @Autowired
    private ContractdetailsTmpService contractdetailsTmpService;

    /**
     * 置结束 过期合同
     */
    @Scheduled(cron = "* * 0/24 * * ?")
    public void invalidContract(){
        List<String> codes = DataSourceFactory.getCodes();
        for (String code : codes) {
            QMENV.setCompCode(code);
            logger.info(QMENV.getCompCode()+"|"+Thread.currentThread().getName()+"|开始过期合同置结束");
            String invalidContractOverTime = SysParamFactory.getSysParam("invalidContractOverTime", SysParam.invalidContractOverTime);
            List<Contractdetails> contracts = contractdetailsService.queryOverTimeContract(invalidContractOverTime);
            if(contracts != null){
                contracts.forEach(contract -> {
                    contractdetailsService.invalidContract(contract);
                    contract.setStatus(ContractDict.CONTRACT_STATUS_FINISH);
                    contractdetailsTmpService.crtContractTmp(contract, ContractDict.OPERATE_UPDATE);
                });
            }
        }

    }

}
