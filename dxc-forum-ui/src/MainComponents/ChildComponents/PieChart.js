import React, { useState, useEffect } from "react";
import Chart from "react-apexcharts";
function PieChart() {
  const [topicName, setTopicName] = useState([]);
  const [topicFrequency, setTopicFrequency] = useState([]);

  useEffect(() => {
    const dict = {};
    const name = [];
    const frequency = [];
    const getTrainerdata = async () => {
      const reqData = await fetch("http://localhost:9090/session");
      const resData = await reqData.json();
      //    dict[resData[0].trainerName] = 1;
      for (let i = 0; i < resData.length; i++) {
        if (dict.hasOwnProperty(resData[i].topicName.trim().toLowerCase())) {
          dict[resData[i].topicName.trim().toLowerCase()] =
            dict[resData[i].topicName.trim().toLowerCase()] + 1;
        } else {
          dict[resData[i].topicName.trim().toLowerCase()] = 1;
        }
      }
      for (var key in dict) {
        name.push(key.trim().toLowerCase());
        frequency.push(dict[key]);
      }
      setTopicName(name);
      setTopicFrequency(frequency);
      console.log(name);
      console.log(frequency);
    };

    getTrainerdata();
  }, []);

  return (
    <React.Fragment>
      <div className="col-6">
        <Chart
          type="pie"
          width={400}
          height={280}
          series={topicFrequency}
          options={{
            title: { text: "Trainer Progress Chart" },
            noData: { text: "Empty Data" },
            // colors:["#f90000","#f0f"],
            labels: topicName,
          }}
        ></Chart>
      </div>
    </React.Fragment>
  );
}
export default PieChart;
