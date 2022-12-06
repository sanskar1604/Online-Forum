import React, { useState, useEffect } from "react";
import Chart from "react-apexcharts";
function CertificationPieChart() {
  const [status, setStatus] = useState([]);
  const [statusFrequency, setstatusFrequency] = useState([]);

  useEffect(() => {
    const dict = {};
    const name = [];
    const frequency = [];
    const getStatusdata = async () => {
      const reqData = await fetch("http://localhost:9090/certification");
      const resData = await reqData.json();
      //    dict[resData[0].trainerName] = 1;
      for (let i = 0; i < resData.length; i++) {
        if (dict.hasOwnProperty(resData[i].status.trim().toLowerCase())) {
          dict[resData[i].status.trim().toLowerCase()] =
            dict[resData[i].status.trim().toLowerCase()] + 1;
        } else {
          dict[resData[i].status.trim().toLowerCase()] = 1;
        }
      }
      for (var key in dict) {
        name.push(key.trim().toLowerCase());
        frequency.push(dict[key]);
      }
      setStatus(name);
      setstatusFrequency(frequency);
      console.log(name);
      console.log(frequency);
    };

    getStatusdata();
  }, []);

  return (
    <React.Fragment>
      <div className="col-6">
        <Chart
          type="pie"
          width={400}
          height={280}
          series={statusFrequency}
          options={{
            title: { text: "Certification Status" },
            noData: { text: "Empty Data" },
            // colors:["#f90000","#f0f"],
            labels: status,
          }}
        ></Chart>
      </div>
    </React.Fragment>
  );
}
export default CertificationPieChart;
