import { useEffect, useState } from "react";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

import { Bar } from "react-chartjs-2";
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);
const options = {
  indexAxis: "y",
  elements: {
    bar: {
      borderWidth: 2,
    },
  },
  responsive: true,
  plugins: {
    legend: {
      position: "right",
    },
    title: {
      display: true,
      text: "Training participants Chart",
    },
  },
};

const Horizontalchart = () => {
  const [data, setData] = useState({
    labels: [],
    datasets: [
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
    ],
  });
  useEffect(() => {
    const fetchData = async () => {
      const url = "http://localhost:9090/session";
      const topicArr = [];
      const batchSizeArr = [];
      const batch1topic = [];
      const batch1Size = [];
      await fetch(url)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
        //   dict = {};
          for (const val of res) {

            batchSizeArr.push(val.batchSize);
            topicArr.push(val.topicName);
          }
          let dict = {};
            for (let i=0;i<topicArr.length; i++) {
                if (dict.hasOwnProperty(topicArr[i])) {
                    dict[topicArr[i]] =
                    parseInt(dict[topicArr[i]]) + parseInt(batchSizeArr[i]);
                } else {
                    dict[topicArr[i]] =  batchSizeArr[i];
                }
            }
          for(let key in dict){
            batch1topic.push(key);
            batch1Size.push(dict[key]);
          }

          console.log(dict);
          setData({
            labels: batch1topic,
            datasets: [
              {
                label: "Participant",
                data: batch1Size,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
            ],
          });
          console.log("arrData", batchSizeArr, topicArr);
        })
        .catch((e) => {
          console.log("error", e);
        });
    };

    fetchData();
  }, []);

  return (
    <div style={{ width: "100%", height: "50%" }}>
      {console.log("dataaaaaaaa", data)}
      <Bar data={data} options={options} />
    </div>
  );
};
export default Horizontalchart;
